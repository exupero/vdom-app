(ns {{name}}.core
  (:require-macros [{{name}}.macros :refer [spy]])
  (:require [vdom.core :refer [renderer]]))

(enable-console-print!)

(defn ui [emit model]
  [:div {}])

(defmulti emit (fn [t & _] t))

(defonce model (atom {}))

(defonce render!
  (let [r (renderer (.getElementById js/document "app"))]
    #(r (ui emit @model))))

(defonce on-update
  (add-watch model :rerender
    (fn [_ _ _ model]
      (render! model))))

(render! @model)
