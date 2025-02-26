public class Calculator {
    public double add (double a, double b){
        return a+b;
    }

    public double subtract(double a, double b){
        return a-b;
    }

    public double multiply(double a, double b){
        return a*b;
    }

    public double divide(double a, double b){
        if (b==0){
            throw new ArithmeticException("Cannot divide by 0!");
        }
        return a/b;
    }

    public double power (double a, double b){
        return Math.pow(a,b);
    }

    public double sqrt(double a){
        if(a<0){
            throw new ArithmeticException("Square root of a negative number is not allowed.");
        }
        return Math.sqrt(a);
    }

    public double log(double a){
        if (a<0){
            throw new ArithmeticException("The logarithm is defined only for positive numbers.");
        }
        return Math.log(a);
    }

    public double sin (double a){
        return Math.sin(Math.toRadians(a));
    }

    public double cos(double a){
        return Math.cos(Math.toRadians(a));
    }

    public double tan (double a){
        if (Math.cos(Math.toRadians(a)) == 0) {
            throw new ArithmeticException("tan(" + a + ") is not defined.");
        }
        return Math.tan(Math.toRadians(a));
    }
    public double cot (double a){
        if (Math.sin(Math.toRadians(a)) == 0) {
            throw new ArithmeticException("cot(" + a + ") is not defined.");
        }
        return 1/Math.tan(Math.toRadians(a));
    }
}


