def jbelmu \
(
    text
):

    return " ".join( t[0] + "".join( sorted( t[1:-1] ) ) + t[-1] if len( t ) > 1 else t for t in text.split() )
