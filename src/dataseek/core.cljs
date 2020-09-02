(ns ^:figwheel-hooks dataseek.core
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf]
            [goog.dom :as gdom]
            [dataseek.components.icons :refer [icons]]
            [dataseek.ui.databases :as databases]
            [dataseek.styles :as styles]))

(rf/reg-event-db
  :initialize
  (fn [_ _]
    {}))

(defn ui []
  [:div.bg-gray-200.h-screen
   {:class [styles/body-text]}
   [icons]
   [:main.container.mx-auto [databases/main]]])

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
