def is_valid_number \
(
    n
    , base
):

    try:
        int( n, base )
        
        
        return True
    except ValueError:
        
        return False
