(ns dataseek.ui.databases
  (:require [re-frame.core :as rf]
            [dataseek.components.icons :refer [icon]]
            [datascript.core :as d]))

(comment
  (let [db (-> (d/empty-db)
               (d/db-with [{:foo "bar"}]))]
    (d/q '[:find ?e
           :in $ ?v
           :where [?e :foo ?v]]
         db
         "bar")))

(defn database [{:keys [title item-count mb-size]}]
  [:div.bg-white.border-gray-400.border-2.flex.flex-col.items-center.p-4.hover:bg-gray-400.cursor-pointer.justify-between
   {:on-click #(rf/dispatch [:active-panel/set :querybuilder])}
   [:h4.text-2xl.font-semibold.text-center
    title]
   [icon :database [:my-4 :fill-current :w-16 :h-16]]
   [:span.text-2xl.text-center
    (str item-count " items - " mb-size " MB")]])

(defn add-database []
  [:div.bg-white.border-gray-400.border-2.hover:bg-gray-400.cursor-pointer.border-dashed.flex.items-center.justify-center
   {:on-click #(rf/dispatch [:active-panel/set :dataloader])}
   [icon :plus [:fill-current :w-16 :h-16]]])

(defn main []
  (let [dbs @(rf/subscribe [:databases])]
    [:div.px-8.py-6.h-screen.flex.flex-col
     [:h2.text-4xl.text-center.mb-10
      "Your databases"]
     [:div.grid.grid-cols-3.gap-4.mb-auto
      (concat
        (for [{:keys [id] :as db} dbs]
          ^{:key id}
          [database db])
        [[add-database]])]
     [:div.mt-auto.flex.items-center
      [:p.mr-4
       "All data is stored locally in your browser and is only accessible from your current browser program and computer, on this page. No network requests are done beyond loading the page, hence it can be used while offline after the initial page load."]
      [:a {:href "https://github.com/uosl/dataseek"
           :target "_blank"}
       [icon :github [:w-10 :h-10 :fill-current :hover:text-gray-400]]]]]))
