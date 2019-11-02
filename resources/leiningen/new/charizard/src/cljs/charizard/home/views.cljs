(ns {{name}}.home.views
  (:require
   [reagent.core :as reagent]
   [{{name}}.home.subs]))

(defn home
  []
  (reagent/create-class
   {:reagent-render (fn []
                      [:div "Home Page"])}))
