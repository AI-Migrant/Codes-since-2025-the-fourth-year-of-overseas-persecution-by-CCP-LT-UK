class Solution
{
    private final StringBuilder s = new StringBuilder( 10000 );
    private int i = 0;
    private int j = 0;
    
    public void append(char x) {
        if (i == s.length()) {
            s.append(x);
        } else {
            s.setCharAt( i, x );
        }
        
        i++;
        j = i;
    }

    public void undo() {
        i--;
    }

    public void redo() {
        if (i < j) {
            i++;
        }
    }

    public String read() {
        return s.substring(0, i);
    }
}