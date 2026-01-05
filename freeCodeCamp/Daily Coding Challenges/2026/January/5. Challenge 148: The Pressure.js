"use strict"




function
tireStatus
(
    pressuresPSI
    , rangeBar
)
{
    return pressuresPSI
        .map
        (
            psi =>
            psi < rangeBar[0]* 14.5038
                ? "Low"
                : psi < rangeBar[1] * 14.5038
                    ? "Good"
                    : "High"
        )
}
