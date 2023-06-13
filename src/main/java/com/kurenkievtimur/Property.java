package com.kurenkievtimur;

public enum Property {
    EVEN {
        @Override
        public boolean isEven(long number) {
            return number % 2 == 0;
        }
    },
    ODD {
        @Override
        public boolean isOdd(long number) {
            return number % 2 != 0;
        }
    },
    BUZZ {
        @Override
        public boolean isBuzz(long number) {
            if (String.valueOf(number).endsWith("7"))
                return true;

            return number % 7 == 0;
        }
    },
    DUCK {
        @Override
        public boolean isDuck(long number) {
            String stringNumber = String.valueOf(number);

            return stringNumber.indexOf("0", 1) > 0;
        }
    },
    PALINDROMIC {
        @Override
        public boolean isPalindromic(long number) {
            String front = String.valueOf(number);
            StringBuilder reverse = new StringBuilder(front).reverse();

            return front.contentEquals(reverse);
        }
    },
    GAPFUL {
        @Override
        public boolean isGapful(long number) {
            String stringNumber = String.valueOf(number);

            String firstDigit = String.valueOf(stringNumber.charAt(0));
            String lastDigit = String.valueOf(stringNumber.charAt(stringNumber.length() - 1));

            return stringNumber.length() > 2 && number % (Long.parseLong(firstDigit + lastDigit)) == 0;
        }
    },
    SPY {
        @Override
        public boolean isSpy(long number) {
            String stringNumber = String.valueOf(number);

            long sumNumber = 0;
            for (int i = 0; i < stringNumber.length(); i++) {
                sumNumber += Long.parseLong(String.valueOf(stringNumber.charAt(i)));
            }

            long productNumber = 1;
            for (int i = 0; i < stringNumber.length(); i++) {
                productNumber *= Long.parseLong(String.valueOf(stringNumber.charAt(i)));
            }

            return sumNumber == productNumber;
        }
    },
    SQUARE {
        @Override
        public boolean isSquare(long number) {
            long square = (long) Math.sqrt(number);

            return (square * square) == number;
        }
    },
    SUNNY {
        @Override
        public boolean isSunny(long number) {
            double square = Math.sqrt(number + 1);

            return square - Math.floor(square) == 0;
        }
    },
    JUMPING {
        @Override
        public boolean isJumping(long number) {
            String stringNumber = String.valueOf(number);
            if (stringNumber.length() == 1) {
                return true;
            }

            for (int i = 0; i < stringNumber.length() - 1; i++) {
                long firstDigit = Long.parseLong(String.valueOf(stringNumber.charAt(i)));
                long secondDigit = Long.parseLong(String.valueOf(stringNumber.charAt(i + 1)));
                if (Math.abs(firstDigit - secondDigit) != 1)
                    return false;
            }

            return true;
        }
    },
    HAPPY {
        @Override
        public boolean isHappy(long number) {
            long digits = number;

            long result = 0;
            while (result != 1 && result != 4) {
                long sum = 0;

                while (digits > 0) {
                    long digit = digits % 10;
                    sum += Math.pow(digit, 2);
                    digits /= 10;
                }

                result = sum;
                digits = result;
            }

            return result == 1;
        }
    },
    SAD {
        @Override
        public boolean isSad(long number) {
            long digits = number;

            long result = 0;
            while (result != 1 && result != 4) {
                long sum = 0;

                while (digits > 0) {
                    long digit = digits % 10;
                    sum += Math.pow(digit, 2);
                    digits /= 10;
                }

                result = sum;
                digits = result;
            }

            return result == 4;
        }
    };

    public boolean isEven(long number) {return false;}
    public boolean isOdd(long number) {return false;}
    public boolean isBuzz(long number) {return false;}
    public boolean isDuck(long number) {return false;}
    public boolean isPalindromic(long number) {return false;}
    public boolean isGapful(long number) {return false;}
    public boolean isSpy(long number) {return false;}
    public boolean isSquare(long number) {return false;}
    public boolean isSunny(long number) {return false;}
    public boolean isJumping(long number) {return false;}
    public boolean isHappy(long number) {return false;}
    public boolean isSad(long number) {return false;}

}