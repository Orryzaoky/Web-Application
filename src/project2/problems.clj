(ns project2.problems
  (:require [clojure.string :as str]))

(def soalmath (->> "resources/math.edn"
               (slurp)
               (read-string)))

(def soalverb (->> "resources/verbal.edn"
                      (slurp)
                      (read-string)))

(def soalinggris (->> "resources/english.edn"
                      (slurp)
                      (read-string)))

(defn take-soal [problem]
  (subvec problem 0 8))

(def score (atom 0))

(defn reset-score []
  (reset! score 0))


(def wrong-question (atom 0))

(defn reset-wrong-question []
  (reset! wrong-question 0))


(def pass (atom 0))

(defn reset-pass []
  (reset! pass 0))


(defn get-soal-id [materi problem-id]
  (loop [index 0
         choice (cond
                  (= materi "math") soalmath
                  (= materi "verbal-logic") soalverb
                  (= materi "english") soalinggris)] 
    (if (= (get-in choice [index :problem-id]) problem-id)
      (get choice index)
      (recur (inc index) choice))))

(defn check [materi id jawaban]
  (let [soal (get-soal-id materi id)]
    (if (nil? jawaban)
      (swap! pass inc)
      (if (= jawaban (get-in soal [:soal :jawaban]))
        (swap! score inc)
        (swap! wrong-question inc))))) 

(def soal (atom nil))

(defn simpan-soal [problems]
  (reset! soal (read-string (str "[" problems "]"))))
