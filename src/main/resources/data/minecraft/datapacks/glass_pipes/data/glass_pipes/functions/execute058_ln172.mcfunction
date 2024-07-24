execute store result score Global mai_scratch3 run data get entity @s Pos[1] 1000
scoreboard players operation Global mai_scratch3 /= c1000 Constant
scoreboard players operation Global mai_scratch3 *= c1000 Constant
execute store result entity @s Pos[1] double 0.001 run scoreboard players get Global mai_scratch3