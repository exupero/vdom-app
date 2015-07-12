(ns {{name}}.core
  (:require [cljs.core.async :as async :refer [chan]]
            [cljs.core.match :refer-macros [match]]
            [vdom.elm :refer [foldp render!]]))

(enable-console-print!)

(defn ui [actions]
  (fn [model]
    nil))

(defn step [model action]
  (match action
    :no-op model))

(let [actions (chan)
      initial-model {}
      models (foldp step initial-model actions)]
  (render! (async/map (ui actions) [models]) js/document.body))
