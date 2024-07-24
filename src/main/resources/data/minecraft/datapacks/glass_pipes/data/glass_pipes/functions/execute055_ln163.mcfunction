execute store result score Global mai_scratch4 run scoreboard players get @s _moving_0
execute store result score Global mai_scratch5 run scoreboard players get @s _moving_1
execute store result score Global mai_scratch6 run scoreboard players get @s _moving_2
scoreboard players operation Global mai_scratch4 *= c250 Constant
scoreboard players operation Global mai_scratch5 *= c250 Constant
scoreboard players operation Global mai_scratch6 *= c250 Constant
execute store result score @s _pos_0 run data get entity @s Pos[0] 1000
execute store result score @s _pos_1 run data get entity @s Pos[1] 1000
execute store result score @s _pos_2 run data get entity @s Pos[2] 1000
scoreboard players operation @s _pos_0 += Global mai_scratch4
scoreboard players operation @s _pos_1 += Global mai_scratch5
scoreboard players operation @s _pos_2 += Global mai_scratch6
execute store result entity @s Pos[0] double 0.001 run scoreboard players get @s _pos_0
execute store result entity @s Pos[1] double 0.001 run scoreboard players get @s _pos_1
execute store result entity @s Pos[2] double 0.001 run scoreboard players get @s _pos_2
scoreboard players set Global mai_scratch3 0