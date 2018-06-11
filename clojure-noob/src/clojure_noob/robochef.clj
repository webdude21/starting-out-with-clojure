(ns clojure-noob.robochef
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]))

(def recipe
  {::ingredients [1 :kg "aubergines"
                  20 :ml "soy sauce"]
   ::steps       ["fry the aubergines"
                  "add the soy sauce"]})

(s/def ::recipe (s/keys :req [::ingredients] :opt [::steps]))
(s/def ::step (s/and string? (complement str/blank?) #(> (count %) 3)))
(s/def ::steps (s/coll-of ::step))
(s/def ::ingredients (s/+ ::ingredient))
(s/def ::ingredient (s/cat :amount number?
                           :unit keyword?
                           :name string?))

(defn cook! [recipe]
  (assert (s/valid? ::recipe recipe))
  recipe)