scoreboard players set @s exit_junction 1
execute as @s run function glass_pipes:pick_dir
execute if score @s done matches 1.. run function glass_pipes:execute060_ln192