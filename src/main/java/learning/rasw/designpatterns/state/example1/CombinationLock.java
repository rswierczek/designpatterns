package learning.rasw.designpatterns.state.example1;

class CombinationLock
{
    public static final String LOCKED = "LOCKED";
    public static final String ERROR = "ERROR";
    public static final String OPEN = "OPEN";
    private int [] combination;

    public String status;
    private int digitsEntered = 0;
    private boolean failed = false;

    public CombinationLock(int[] combination)
    {
        this.combination = combination;
        reset();
    }

    private void reset()
    {
        status = LOCKED;
        digitsEntered = 0;
        failed = false;
    }

    public void enterDigit(int digit)
    {
        if (LOCKED.equals(status)) {
            status = "";
        } else if (ERROR.equals(status) || OPEN.equals(status)) {
            reset();
            status = "";
        }
        status += digit;
        if (combination[digitsEntered] != digit) {
            failed = true;
        }
        digitsEntered++;

        if (digitsEntered == combination.length) {
            status = failed ? ERROR : OPEN;
        }
    }
}
