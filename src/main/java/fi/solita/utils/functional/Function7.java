package fi.solita.utils.functional;

public abstract class Function7<T1, T2, T3, T4, T5, T6, T7, R> extends MultiParamFunction<Tuple7<T1, T2, T3, T4, T5, T6, T7>, R> {

    public abstract R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7);

    public final <U> Function7<T1, T2, T3, T4, T5, T6, T7, U> andThen(final Apply<? super R, ? extends U> next) {
        final Function7<T1, T2, T3, T4, T5, T6, T7, R> self = this;
        return new Function7<T1, T2, T3, T4, T5, T6, T7, U>() {
            @Override
            public U apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
                return next.apply(self.apply(t1, t2, t3, t4, t5, t6, t7));
            }
        };
    }

    public final Function1<Tuple7<T1, T2, T3, T4, T5, T6, T7>, R> tuppled() {
        return new Function1<Tuple7<T1, T2, T3, T4, T5, T6, T7>, R>() {
            @Override
            public R apply(Tuple7<T1, T2, T3, T4, T5, T6, T7> t) {
                return Function7.this.apply(t._1, t._2, t._3, t._4, t._5, t._6, t._7);
            }
        };
    }
}