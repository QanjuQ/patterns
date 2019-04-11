(ns patterns.core)

(def reversed-repeat (comp (partial apply repeat) reverse list))

(def solid-line (partial reversed-repeat "*"))

(def space-line (partial reversed-repeat " "))

(def dec-two (comp dec dec))

(def append (comp
             (partial apply concat)
             (juxt rest (comp list first))
             cons))

(def join-with-newline  (partial mapcat (partial append "\n")))

(defn repeat-twice-less [count what-to] (repeat (dec-two count) what-to))

(def hollow-star-line
  (comp
   (partial append "*")
   (partial cons "*")
   space-line
   dec-two))

(def inner-body
  (comp
   (partial map hollow-star-line)
   repeat-twice-less))

(defn hollow-rectangle [length breadth]
  (comp (append (solid-line breadth)
           (cons (solid-line breadth) (inner-body length breadth)))))

(defn render [shape length width] (print (shape length width)))

(def solid-rectangle (comp (partial map solid-line) repeat))