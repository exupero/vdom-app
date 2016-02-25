(ns leiningen.new.vdom-app
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "vdom-app"))

(defn vdom-app [name]
  (let [data {:name name
              :path (name-to-path name)}]
    (->files data
      [".gitignore" (render ".gitignore" data)]
      ["index.html" (render "index.html" data)]
      ["project.clj" (render "project.clj" data)]
      "src/{{path}}"
      ["src/{{path}}/core.cljs" (render "src/vdom_app/core.cljs" data)]
      ["src/{{path}}/macros.clj" (render "src/vdom_app/macros.clj" data)]
      "resources/public"
      ["resources/public/index.html" (render "resources/public/index.html" data)]
      "resources/public/js"
      "resources/public/css"
      ["resources/public/css/{{name}}.css" (render "resources/public/css/styles.css" data)]
      ["scripts/build.clj" (render "scripts/build.clj" data)]
      ["scripts/figwheel.clj" (render "scripts/figwheel.clj" data)])))
