(ns clojure_noob.core
  (:gen-class))

(defn -main
  [& args]

  (defn avarage
    [numbers]
      (/ (apply + numbers) (count numbers)))

  (printf "Result: %d%n" (avarage [60 80 100 400]))
)