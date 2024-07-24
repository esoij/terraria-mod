scoreboard players set Global is__scratch0 1
execute if block ~1 ~ ~ minecraft:glass if block ~-1 ~ ~ minecraft:glass run function glass_pipes:execute050_ln99
execute if score Global is__scratch0 matches 1.. run scoreboard players set Global glass_x 0
scoreboard players set Global is__scratch0 1
execute if block ~ ~1 ~ minecraft:glass if block ~ ~-1 ~ minecraft:glass run function glass_pipes:execute051_ln105
execute if score Global is__scratch0 matches 1.. run scoreboard players set Global glass_y 0
scoreboard players set Global is__scratch0 1
execute if block ~ ~ ~1 minecraft:glass if block ~ ~ ~-1 minecraft:glass run function glass_pipes:execute052_ln111
execute if score Global is__scratch0 matches 1.. run scoreboard players set Global glass_z 0
execute store result score Global is__scratch0 run scoreboard players get Global glass_x
scoreboard players operation Global is__scratch0 += Global glass_y
scoreboard players operation Global is__scratch0 += Global glass_z
execute store result score Global glass run scoreboard players get Global is__scratch0
scoreboard players set Global is__scratch0 1
execute if score Global glass matches 2..2 if block ~ ~ ~ minecraft:air run function glass_pipes:execute053_ln119
execute if score Global is__scratch0 matches 1.. run scoreboard players set Global ReturnValue 0