(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.122" :exclusions [org.apache.ant/ant]]
                 [org.clojure/core.match  "0.3.0-alpha4"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [vdom "0.1.1-SNAPSHOT"]]
  :plugins [[lein-cljsbuild "0.3.2"]
            [lein-figwheel "0.4.0"]]
  :cljsbuild {:builds {:dev {:source-paths ["src"]
                             :incremental true
                             :jar true
                             :assert true
                             :figwheel {:on-jsload "{{name}}.core/figwheel-reload"}
                             :compiler {:main {{name}}.core
                                        :output-to "resources/public/js-dev/{{path}}.js"
                                        :output-dir "resources/public/js-dev"
                                        :asset-path "js-dev"
                                        :warnings true
                                        :elide-asserts true
                                        :optimizations :none
                                        :source-map "resources/public/js-dev/{{path}}.js.map"
                                        :pretty-print true
                                        :output-wrapper false}}
                       :prod {:source-paths ["src"]
                              :incremental true
                              :jar true
                              :assert true
                              :compiler {:output-to "resources/public/js/{{path}}.js"
                                         :warnings true
                                         :elide-asserts true
                                         :optimizations :advanced
                                         :pretty-print false
                                         :output-wrapper false}}}}
  :figwheel {:css-dirs ["resources/public/css"]})
