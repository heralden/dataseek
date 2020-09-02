(ns dataseek.components.icons)

;;;; Usage
;; Get icons from https://icomoon.io/app/ Free pack.
;; Paste the SVG markup into http://htmltohiccup.herokuapp.com/ to convert it
;; to hiccup, then paste that in here under a new `symbol` tag. You should
;; clean it up by removing any `:svg` parent tag, and removing every attribute
;; other than `viewBox`. Note that the hiccup returned will specify `viewbox`
;; with lowercase b, which React doesn't like, so make sure to uppercase the b.

(defn icon
  [icon-kw & [classes]]
  (let [icon-name (str "icon-" (name icon-kw))]
    [:svg.flex-shrink-0
     {:class (into [icon-name] classes)}
     [:use {:xlinkHref (str "#" icon-name)}]]))

(defn icons []
  [:svg
   {:version "1.1"
    :height "0"
    :width "0"
    :style {:position "absolute" :width 0 :height 0}}
   [:defs

    [:symbol#icon-database
     {:viewBox "0 0 32 32"}
     [:path
      {:d
       "M16 0c-8.837 0-16 2.239-16 5v4c0 2.761 7.163 5 16 5s16-2.239 16-5v-4c0-2.761-7.163-5-16-5z"}]
     [:path
      {:d
       "M16 17c-8.837 0-16-2.239-16-5v6c0 2.761 7.163 5 16 5s16-2.239 16-5v-6c0 2.761-7.163 5-16 5z"}]
     [:path
      {:d
       "M16 26c-8.837 0-16-2.239-16-5v6c0 2.761 7.163 5 16 5s16-2.239 16-5v-6c0 2.761-7.163 5-16 5z"}]]

    [:symbol#icon-github
     {:viewBox "0 0 32 32"}
     [:path
      {:d
       "M16 0.395c-8.836 0-16 7.163-16 16 0 7.069 4.585 13.067 10.942 15.182 0.8 0.148 1.094-0.347 1.094-0.77 0-0.381-0.015-1.642-0.022-2.979-4.452 0.968-5.391-1.888-5.391-1.888-0.728-1.849-1.776-2.341-1.776-2.341-1.452-0.993 0.11-0.973 0.11-0.973 1.606 0.113 2.452 1.649 2.452 1.649 1.427 2.446 3.743 1.739 4.656 1.33 0.143-1.034 0.558-1.74 1.016-2.14-3.554-0.404-7.29-1.777-7.29-7.907 0-1.747 0.625-3.174 1.649-4.295-0.166-0.403-0.714-2.030 0.155-4.234 0 0 1.344-0.43 4.401 1.64 1.276-0.355 2.645-0.532 4.005-0.539 1.359 0.006 2.729 0.184 4.008 0.539 3.054-2.070 4.395-1.64 4.395-1.64 0.871 2.204 0.323 3.831 0.157 4.234 1.026 1.12 1.647 2.548 1.647 4.295 0 6.145-3.743 7.498-7.306 7.895 0.574 0.497 1.085 1.47 1.085 2.963 0 2.141-0.019 3.864-0.019 4.391 0 0.426 0.288 0.925 1.099 0.768 6.354-2.118 10.933-8.113 10.933-15.18 0-8.837-7.164-16-16-16z"}]]

    [:symbol#icon-plus
     {:viewBox "0 0 32 32"}
     [:path
      {:d
       "M31 12h-11v-11c0-0.552-0.448-1-1-1h-6c-0.552 0-1 0.448-1 1v11h-11c-0.552 0-1 0.448-1 1v6c0 0.552 0.448 1 1 1h11v11c0 0.552 0.448 1 1 1h6c0.552 0 1-0.448 1-1v-11h11c0.552 0 1-0.448 1-1v-6c0-0.552-0.448-1-1-1z"}]]]])

