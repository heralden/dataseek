(ns dataseek.ui.databases
  (:require [dataseek.components.icons :refer [icon]]))

(defn database [{:keys [title item-count mb-size]}]
  [:div.bg-white.border-gray-400.border-2.flex.flex-col.items-center.p-4.hover:bg-gray-400.cursor-pointer.justify-between
   [:h4.text-2xl.font-semibold.text-center
    title]
   [icon :database [:my-4 :fill-current :w-16 :h-16]]
   [:span.text-2xl.text-center
    (str item-count " items - " mb-size " MB")]])

(defn add-database []
  [:div.bg-white.border-gray-400.border-2.hover:bg-gray-400.cursor-pointer.border-dashed.flex.items-center.justify-center
   [icon :plus [:fill-current :w-16 :h-16]]])

(def sample-dbs
  [{:id 0
    :title "Student exams"
    :item-count 173
    :mb-size 2}
   {:id 1
    :title "Watched movies"
    :item-count 530
    :mb-size 13}])

(defn main []
  [:div.px-8.py-6.h-screen.flex.flex-col
   [:h2.text-4xl.text-center.mb-10
    "Your databases"]
   [:div.grid.grid-cols-3.gap-4.mb-auto
    (concat
      (for [{:keys [id] :as db} sample-dbs]
        ^{:key id}
        [database db])
      [[add-database]])]
   [:div.mt-auto.flex.items-center
    [:p.mr-4
     "All data is stored locally in your browser and is only accessible from your current browser program and computer, on this page. No network requests are done beyond loading the page, hence it can be used while offline after the initial page load."]
    [:a {:href "https://github.com/uosl/dataseek"
         :target "_blank"}
     [icon :github [:w-10 :h-10 :fill-current :hover:text-gray-400]]]]])
