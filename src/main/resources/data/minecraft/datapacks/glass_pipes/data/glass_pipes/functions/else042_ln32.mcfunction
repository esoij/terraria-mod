scoreboard players set @s initialize 0
execute store result score Global x run scoreboard players get @s _moving_0
execute store result score Global y run scoreboard players get @s _moving_1
execute store result score Global z run scoreboard players get @s _moving_2
execute store result score Global pic_scratch2 run scoreboard players get @s _moving_0
execute store result score Global pic_scratch3 run scoreboard players get @s _moving_1
execute store result score Global pic_scratch4 run scoreboard players get @s _moving_2
scoreboard players operation Global pic_scratch2 *= minus Constant
scoreboard players operation Global pic_scratch3 *= minus Constant
scoreboard players operation Global pic_scratch4 *= minus Constant
execute store result score Global _was_moving_0 run scoreboard players get Global pic_scratch2
execute store result score Global _was_moving_1 run scoreboard players get Global pic_scratch3
execute store result score Global _was_moving_2 run scoreboard players get Global pic_scratch4
scoreboard players set Global searching 1
scoreboard players set Global first 1
execute if score Global searching matches 1.. run function glass_pipes:while041_ln42