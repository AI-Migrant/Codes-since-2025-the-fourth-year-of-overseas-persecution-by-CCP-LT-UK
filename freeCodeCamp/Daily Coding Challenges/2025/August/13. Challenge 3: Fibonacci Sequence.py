def fibonacci_sequence \
(
    start_sequence
    , length
):
    
    while \
    (
        len( start_sequence ) < length
    ):
        start_sequence.append( sum( start_sequence[-2:] ) )
    
    
    return start_sequence[:length]