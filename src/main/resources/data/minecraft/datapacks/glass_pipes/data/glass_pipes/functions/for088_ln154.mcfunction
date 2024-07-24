scoreboard players set @s mai_scratch0 1
execute as @s run function glass_pipes:get_facing_dir
execute store result score Global facing_dir run scoreboard players get Global ReturnValue
scoreboard players operation Global _id = @s travel
scoreboard players set Global mai_scratch1 1
execute as @e if score @s _id = Global _id run function glass_pipes:execute068_ln156
execute if score Global mai_scratch1 matches 1.. at @s align xyz positioned ~0.5 ~ ~0.5 run function glass_pipes:execute073_ln220
execute if score @s pipe_sound matches 1.. at @s run function glass_pipes:execute087_ln241
scoreboard players set @s pipe_slow 0
scoreboard players set @s mai_scratch0 0