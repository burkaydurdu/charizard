(defproject {{name}} "0.1.0"
  :description "Client and server side template"
  :url "https://github/burkaydurdu/charizard"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]
                 [reagent "0.8.1"]
                 [re-frame "0.10.9"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [clj-commons/secretary "1.2.4"]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-less "1.7.5"]
            [lein-ring "0.12.5"]
            [lein-cljfmt "0.6.4"]]

  :source-paths ["src/clj" "src/cljs"]
  
  :resource-paths ["resources"]

  :main ^:skip-aot {{name}}.core

  :ring {:handler {{name}}.core/handler}
   
  :min-lein-version "2.6.1"

  :profiles {:uberjar {:aot :all}

             :dev {:dependencies [[binaryage/devtools "0.9.10"]
                                  [day8.re-frame/re-frame-10x "0.4.2"]
                                  [day8.re-frame/tracing "0.5.3"]
                                  [figwheel-sidecar "0.5.18"]
                                  [ring "1.7.1"]
                                  [compojure "1.6.1"]
                                  [amalloy/ring-gzip-middleware "0.1.3"]]

                   :plugins [[lein-figwheel "0.5.18"]]}}
  
  :cljsbuild {:builds [{:id           "dev"
                        :source-paths ["src/cljs"]
                        :figwheel     {:on-jsload "{{name}}.core/mount-root"}
                        :compiler     {:main {{name}}.core
                                       :output-to            "resources/public/js/compiled/app.js"
                                       :output-dir           "resources/public/js/compiled/out"
                                       :asset-path           "js/compiled/out"
                                       :source-map-timestamp true
                                       :preloads             [devtools.preload
                                                              day8.re-frame-10x.preload]
                                       :closure-defines      {"re_frame.trace.trace_enabled_QMARK_"        true
                                                              "day8.re_frame.tracing.trace_enabled_QMARK_" true}}}]})
