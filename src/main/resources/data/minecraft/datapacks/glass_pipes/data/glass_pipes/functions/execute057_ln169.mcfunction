execute store result score Global mai_scratch3 run data get entity @s Pos[0] 1000
scoreboard players operation Global mai_scratch3 /= c1000 Constant
scoreboard players operation Global mai_scratch3 *= c1000 Constant
scoreboard players add Global mai_scratch3 500
execute store result entity @s Pos[0] double 0.001 run scoreboard players get Global mai_scratch3