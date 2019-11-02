(ns leiningen.new.charizard
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "charizard"))

(defn charizard
  "Charizard Template"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' charizard project.")
    (->files data
             ["src/clj/{{sanitized}}/core.clj" (render "src/clj/charizard/core.clj" data)]
             ["src/cljs/{{sanitized}}/common/events.cljs" (render "src/cljs/charizard/common/events.cljs" data)]
             ["src/cljs/{{sanitized}}/common/subs.cljs" (render "src/cljs/charizard/common/subs.cljs" data)]
             ["src/cljs/{{sanitized}}/home/events.cljs" (render "src/cljs/charizard/home/events.cljs" data)]
             ["src/cljs/{{sanitized}}/home/subs.cljs" (render "src/cljs/charizard/home/subs.cljs" data)]
             ["src/cljs/{{sanitized}}/home/views.cljs" (render "src/cljs/charizard/home/views.cljs" data)]
             ["src/cljs/{{sanitized}}/navigation/events.cljs" (render "src/cljs/charizard/navigation/events.cljs" data)]
             ["src/cljs/{{sanitized}}/navigation/subs.cljs" (render "src/cljs/charizard/navigation/subs.cljs" data)]
             ["src/cljs/{{sanitized}}/navigation/views.cljs" (render "src/cljs/charizard/navigation/views.cljs" data)]
             ["src/cljs/{{sanitized}}/core.cljs" (render "src/cljs/charizard/core.cljs" data)]
             ["src/cljs/{{sanitized}}/db.cljs" (render "src/cljs/charizard/db.cljs" data)]
             ["src/cljs/{{sanitized}}/routes.cljs" (render "src/cljs/charizard/routes.cljs" data)]
             ["project.clj" (render "project.clj" data)]
             ["resources/public/index.html" (render "resources/public/index.html" data)]
)))
