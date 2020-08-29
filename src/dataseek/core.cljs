(ns ^:figwheel-hooks dataseek.core
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf]
            [goog.dom :as gdom]))

(rf/reg-event-db
  :initialize
  (fn [_ _]
    {}))

(defn greet [target]
  (str "Hello, " target "!"))

(defn ui []
  [:div
   [:h1.text-red-600 (greet "World")]])

(defn render
  []
  (rdom/render [ui]
               (gdom/getElement "app")))

(defn ^:after-load clear-cache-and-render! []
  (rf/clear-subscription-cache!)
  (render))

(defn main []
  (rf/dispatch-sync [:initialize])
  (render))
