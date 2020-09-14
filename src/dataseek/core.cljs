(ns ^:figwheel-hooks dataseek.core
  (:require [reagent.dom :as rdom]
            [re-frame.core :as rf]
            [goog.dom :as gdom]
            [dataseek.events]
            [dataseek.subs]
            [dataseek.components.icons :refer [icons]]
            [dataseek.ui.databases :as databases]
            [dataseek.ui.dataloader :as dataloader]
            [dataseek.ui.querybuilder :as querybuilder]
            [dataseek.styles :as styles]))

(rf/reg-event-db
  :initialize
  (fn [_ _]
    {:active-panel :databases
     :databases [{:id 0
                  :title "Student exams"
                  :item-count 173
                  :mb-size 2}
                 {:id 1
                  :title "Watched movies"
                  :item-count 530
                  :mb-size 13}]}))

(defn panel []
  (let [active-panel-kw @(rf/subscribe [:active-panel])]
    (case active-panel-kw
      :databases [databases/main]
      :dataloader [dataloader/main]
      :querybuilder [querybuilder/main])))

(defn ui []
  [:div.bg-gray-200.h-screen
   {:class [styles/body-text]}
   [icons]
   [:main.container.mx-auto
    [panel]]])

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
