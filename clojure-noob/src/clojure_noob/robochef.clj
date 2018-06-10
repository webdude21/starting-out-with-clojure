(ns clojure-noob.robochef
  (:require [clojure.spec.alpha :as s]))

(def recipe
  {::ingredients [1 :kg "aubergines"
                  20 :ml "soy sauce"]
   ::steps       ["fry the aubergines"
                  "add the soy sauce"]})

(s/def ::recipe (s/map-of keyword? vector?))
(s/def ::steps (s/coll-of string? []))
(s/def ::ingredients (s/+ ::ingredient))
(s/def ::ingredient (s/cat :amount number?
                           :unit keyword?
                           :name string?))

(defn cook! [recipe]
  (assert (s/valid? ::recipe recipe))
  recipe)