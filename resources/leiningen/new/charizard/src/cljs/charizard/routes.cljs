(ns {{name}}.routes
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.history.Html5History)
  (:require
   [secretary.core :as secretary]
   [re-frame.core :refer [dispatch]]
   [goog.events :as events]
   [goog.history.EventType :as EventType]
   [{{name}}.common.events]
   [{{name}}.navigation.events]
   [{{name}}.home.views :refer [home]]))

(defn hook-browser-navigation! []
  (doto (Html5History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (secretary/set-config! :prefix "#")

  (defroute "/home" []
    (dispatch [:set-active-panel [home :home]]))

  (hook-browser-navigation!))
