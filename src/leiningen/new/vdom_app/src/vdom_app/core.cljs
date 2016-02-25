(ns {{name}}.core
  (:require-macros [{{name}}.macros :refer [spy]])
  (:require [cljs.core.async :as async :refer [chan put!]]
            [cljs.core.match :refer-macros [match]]
            [vdom.elm :refer [foldp render!]]))

(enable-console-print!)

(defn ui [model emit]
  [:div {}])

(defn step [model action]
  (match action
    :no-op model))

(def initial-model {})

(defonce actions (chan))
(def emit #(put! actions %))

(defonce models (foldp step initial-model actions))

(defonce setup
  (render! (async/map #(ui % emit) [models]) (.getElementById js/document "app")))

(defn figwheel-reload []
  (put! actions :no-op))
