(ns {{name}}.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]
            [clojure.java.io :as io]
            [ring.util.response :as r]
            [ring.middleware.resource :as re]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.gzip :refer [wrap-gzip]]
            [compojure.core :refer :all]))

(defroutes rr
  (GET "/" [] (r/resource-response "index.html" {:root "public"})))

(def handler (-> rr
                 (re/wrap-resource "/public")
                 wrap-reload
                 wrap-gzip))

(defn -main []
  (jetty/run-jetty handler {:port 3011}))
