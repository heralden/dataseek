(ns dataseek.components.navbar
  (:require [dataseek.components.icons :refer [icon]]
            [re-frame.core :as rf]))

(defn nav-item [{:keys [label panel-kw active?]}]
  [:li.text-2xl.ml-4.leading-loose.cursor-pointer.hover:text-indigo-600
   {:class (when active?
             [:text-indigo-600 :border-b-4 :border-indigo-600])
    :on-click #(rf/dispatch [:active-panel/set panel-kw])}
   label])

(defn nav [{:keys [items]}]
  (let [active-panel-kw @(rf/subscribe [:active-panel])]
    (into [:ul.flex]
          (for [{:keys [panel-kw] :as item} items]
            [nav-item (assoc item :active? (= panel-kw active-panel-kw))]))))

(def items-data
  [{:label "Load data" :panel-kw :dataloader}
   {:label "Build query" :panel-kw :querybuilder}])

(defn main []
  [:div.flex.items-center.justify-between.py-3.px-2
   [:div.flex.items-center
    [:button.text-6xl.font-extrabold.mr-6.hover:text-gray-500
     {:on-click #(rf/dispatch [:active-panel/set :databases])}
     "‹"]
    [icon :database [:fill-current :w-12 :h-12 :mr-6]]
    [:h2.text-2xl.font-semibold "Database name"]]
   [:div.flex.items-center
    [nav {:items items-data}]]])
