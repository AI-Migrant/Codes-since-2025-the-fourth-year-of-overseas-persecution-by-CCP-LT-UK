def is_balanced \
(
    s
):
    vowels = "AEIOUaeiou"
    
    
    return len( [ c for c in s[:len( s ) // 2] if c in vowels ] ) \
        == len( [ c for c in s[( len( s ) + 1 ) // 2:] if c in vowels ] )
