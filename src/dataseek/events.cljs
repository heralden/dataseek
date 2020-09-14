(ns dataseek.events
  (:require [re-frame.core :refer [reg-event-db]]))

(reg-event-db
 :active-panel/set
 (fn [db [_ panel-kw]]
   (assoc db :active-panel panel-kw)))
