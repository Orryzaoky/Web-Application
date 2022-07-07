(ns project2.problems)

(def soalmath (->> "resources/sample.edn"
               (slurp)
               (read-string)))

(def soalverb (->> "resources/sample2.edn"
                      (slurp)
                      (read-string)))

(def soalinggris (->> "resources/sample3.edn"
                      (slurp)
                      (read-string)))

(defn take-soal [problem]
  (subvec problem 0 8))

(def score (atom 0))

(defn reset-score []
  (reset! score 0))

(defn get-id [problem-id]
  (loop [index 0
         choice (cond
                  (= (apply str (take 3 problem-id)) "565") soalmath
                  (= (apply str (take 4 problem-id)) "5699") soalverb
                  (= (apply str (take 4 problem-id)) "5690") soalinggris)] 
    (if (= (:problem-id (get choice index)) problem-id)
      (get choice index)
      (recur (inc index) choice))))

(defn check [jawaban id]
  (let [soal (get-id id)]
    (when (= jawaban (get-in soal [:soal :jawaban]))
      (swap! score inc))))

