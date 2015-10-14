(ns leiningen.new.vdom-app
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "vdom-app"))

(defn vdom-app [name]
  (let [data {:name name
              :path (name-to-path name)}]
    (->files data
      ["index.html" (render "index.html" data)]
      ["project.clj" (render "project.clj" data)]
      "externs"
      ["externs/vdom.js" (render "externs/vdom.js" data)]
      "src/{{path}}"
      ["src/{{path}}/core.cljs" (render "src/vdom_app/core.cljs" data)]
      ["src/{{path}}/macros.clj" (render "src/vdom_app/macros.clj" data)]
      ["resources/public/dev.html" (render "resources/public/dev.html" data)]
      "resources/public/js"
      ["resources/public/js/vdom.js" (render "resources/public/js/vdom.js" data)]
      "resources/public/css"
      ["resources/public/css/{{path}}.css" (render "resources/public/css/styles.css" data)])))
