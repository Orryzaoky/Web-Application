(ns project2.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [project2.dashboard :as dashboard]
            [project2.questionmath :as math] 
            [project2.result :as result]
            [project2.problems :as prob] 
            [project2.questionverb :as verb] 
            [ring.util.response :as resp]
            [project2.questionenglish :as eng]))

(defroutes app-routes
  (GET "/" [] dashboard/dashboard)
  (GET "/Matematika" [] (math/soalmath (prob/take-soal (shuffle prob/soalmath)))) 
  (POST "/quiz" [no0 no0-id no1 no1-id no2 no2-id no3 no3-id no4 no4-id no5 no5-id no6 no6-id no7 no7-id] 
    (do (prob/reset-score)
        (prob/check no0 no0-id)
        (prob/check no1 no1-id) 
        (prob/check no2 no2-id)
        (prob/check no3 no3-id)
        (prob/check no4 no4-id)
        (prob/check no5 no5-id)
        (prob/check no6 no6-id)
        (prob/check no7 no7-id)
        (resp/redirect "/result")))
  (GET "/result" [] (result/result prob/score prob/soalmath))
  (GET "/Pembahasan" [] result/bahas)
  (GET "/bahasmath1" [] result/bahasmath1)
  (GET "/bahasmath2" [] result/bahasmath2)
  (GET "/English" [] (eng/soalinggris1 (shuffle prob/soalinggris)))
  (GET "/soalinggris2" [] (eng/soalinggris2 (shuffle prob/soalinggris)))
  (POST "/quizinggris" [no0 no1] (do (prob/reset-score)
                                     (prob/check1 no0 0)
                                     (prob/check1 no1 1)
                                     (resp/redirect "/resultinggris")))
  (GET "/resultinggris" [] (result/resultinggris prob/score1 prob/soalinggris))
  (GET "/PembahasanEng" [] result/bahaseng)
  (GET "/bahaseng1" [] result/bahaseng1)
  (GET "/bahaseng2" [] result/bahaseng2)
  (GET "/Verbal" [] verb/questionverb)


  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
