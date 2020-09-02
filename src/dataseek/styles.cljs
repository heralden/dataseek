(ns dataseek.styles)

(defn comb [mod class]
  (keyword (str (name mod) ":" (name class))))

(def body-text :text-gray-700)
