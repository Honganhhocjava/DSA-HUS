package Hw3_22000070_NguyenThiAnh.BaiTap1;

public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static float gcd(float denominator1, float denominator2) {
        while (denominator2 != 0) {
            float temp = denominator2;
            denominator2 = denominator1 % denominator2;
            denominator1 = temp;
        }
        return denominator1;
    }

    public Fraction add(Fraction c) {
        if(this.denominator == c.denominator) {
            float newNumerator = this.numerator + c.numerator;
            return new Fraction(newNumerator,this.denominator);
        } else {
            float newDenominator = Math.abs((this.denominator * c.denominator) / gcd(this.denominator,c.denominator));
            float newNumerator1 = this.numerator * (newDenominator / this.denominator) + c.numerator *(newDenominator/c.denominator);
            return new Fraction(newNumerator1,newDenominator);
        }
    }

    public Fraction minus(Fraction c) {
        if(this.denominator == c.denominator) {
            float newNumerator = this.numerator - c.numerator;
            return new Fraction(newNumerator,this.denominator);
        } else {
            float newDenominator = Math.abs((this.denominator * c.denominator) / gcd(this.denominator,c.denominator));
            float newNumerator1 = this.numerator * (newDenominator / this.denominator) - c.numerator *(newDenominator/c.denominator);
            return new Fraction(newNumerator1,newDenominator);
        }
    }

    public Fraction multi(Fraction c) {
        float newNumerator = this.numerator * c.numerator;
        float newDenominator = this.denominator * c.denominator;
        return new Fraction(newNumerator,newDenominator);
    }

    public Fraction divi(Fraction c) {
        if (c.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        float newNumerator = this.numerator * c.denominator;
        float newDenominator = this.denominator * c.numerator;
        return new Fraction(newNumerator,newDenominator);
    }

    public Fraction normalize(Fraction c) {
        float gcdValue = gcd(c.numerator, c.denominator);
        return new Fraction(c.numerator / gcdValue, c.denominator / gcdValue);
    }

    public Fraction result() {
        return normalize(this);
    }
    @Override
    public String toString() {
        if(numerator == 0) {
            return "0.0";
        }
        if(denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;
    }
}
