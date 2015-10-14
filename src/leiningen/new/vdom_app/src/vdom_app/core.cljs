(ns {{name}}.core
  (:require-macros [{{name}}.macros :refer [spy]])
  (:require [cljs.core.async :as async :refer [chan put!]]
            [cljs.core.match :refer-macros [match]]
            [vdom.elm :refer [foldp render!]]))

(enable-console-print!)

(defn ui [actions model])

(defn step [model action]
  (match action
    :no-op model))

(def initial-model {})

(defonce actions (chan))

(defonce models (foldp step initial-model actions))

(defonce setup
  (render! (async/map #(ui actions %) [models]) js/document.body))

(defn figwheel-reload []
  (put! actions :no-op))
