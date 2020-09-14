(ns dataseek.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 :active-panel
 (fn [db]
   (:active-panel db)))

(reg-sub
 :databases
 (fn [db]
   (:databases db)))
