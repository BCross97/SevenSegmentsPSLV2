Number reading
+>+>+>+>+>+>+>+>+
<<<<<<<<
[
    ,>
]
[
    <
]
Tras esto el numero queda escrito en las primeras 9 posiciones!
[
    >
]
Compare position 6 == 124
Move to position 6!
<<<
Copy value of 6th to 16th position!
[
    >>>>>>>>>+>+<<<<<<<<<<-
]
>>>>>>>>>
[
    <<<<<<<<<+>>>>>>>>>-
]
> Set in position 16th
Set value of 18th to 1 for checking if 6th == 124 (Char numb for |)!
>>+<< 
<<<<++++++++ 8 in 12th!
[
    >++++<-
]>- 31 in 13th!
[
    >++++<-
]> 124 in 14th
Substract 124 to 16th!
[
    >>-<<-
]
Check if 16th got to 0!
>>[>]>>
Code if 16th == 124 (0 2 6 8)!
[
    Check if position 3 == 124!
    -
    <<<<<<<<<<<<<<<
    Copy value of 3rd to 16th position!
    [
        >>>>>>>>>>>>+>+<<<<<<<<<<<<<-
    ]
    >>>>>>>>>>>>
    [
        <<<<<<<<<<<<+>>>>>>>>>>>>-
    ]
    > Set position back to 16th!
    Set value of 18th to 1 for checking if 6th == 124 (Char numb for |)
    >>+<< Set back to position 16th!
    <<<<++++++++ 8 in 12th!
    [
        >++++<-
    ]>- 31 in 13th
    [
        >++++<-
    ]> 124 in 14th
    Substract 124 to 16th!
    [
        >>-<<-
    ]
    Check if 16th got to 0!
    >>[>]>>
    if 16th == 124; then we are at 18th position!
    [
        Indeed; it IS at the 18th position
        Remaining candidates are 0 6 and 8 
        Lets clean it
        -
        Check if position 4 equals 95
        Go to position 4 from 18th
        !<<<<<<<<<<<<<<
        Copy 4 to 16
        ![
            >>>>>>>>>>>+>+<<<<<<<<<<<<-
        ]
        >>>>>>>>>>>
        [
            <<<<<<<<<<<+>>>>>>>>>>>-
        ]>
        Set 18th to 1 for validating
        >>+
        Set 14th to 95 for validating if 16th == 95
        !<<<<< Standing at 13th; setting it to 19
        !+++++ 
        ![
            >+++++++++++++++++++<-
        ]> Standing at 14th with 95 in it
        Substract 95 to 16th
        ![
            >>-<<-
        ]
        Check if 16th == 0
        !>>[>]>>
        [
            Indeed 16th == 0; Remaining candidates are 6 and 8
            Lets clean it (We stand in position 18th)
            !-
            Now we have to check the 5th position; if it equalls 124 then the answer is 8; if not the answer is 6
            Check if position 5 == 124!
            <<<<<<<<<<<<< We now stand in the 5th position
            Copy value of 5rd to 16th position
            ![
                >>>>>>>>>>+>+<<<<<<<<<<<-
            ]
            !>>>>>>>>>>
            [
                <<<<<<<<<<+>>>>>>>>>>-
            ]
            > Set position back to 16th!
            Set value of 18th to 1 for checking if 6th == 124 (Char numb for |)
            >>+<< Set back to position 16th!
            <<<<++++++++ 8 in 12th!
            [
                >++++<-
            ]>- 31 in 13th
            [
                >++++<-
            ]> 124 in 14th
            Substract 124 to 16th!
            [
                >>-<<-
            ]
            Check if 16th got to 0!
            >>[>]>>
            Code if 16th == 124; then we are at 18th position!
            ?[
                Hooray we found 8; we shall print it
                - Clean
                ++
                [
                    >++<-
                ]> This is just a fancy and very 
                unnecessary way of printing 8
                [
                    >++<-
                ]>
                .
                #
            ]
            It wasnt 8; therefore it must be 6
            ++++++
            .
            ------
            #   
        ]
        It is NOT equivalent to 95; therefore it must be a 0
        ++++.----
        #
    ]
    Found 2; we shall print it!
    ++.--
    #
    *
    *
    *
    # To make sure the program exits (# is the symbol I defined for exiting the program
]
#