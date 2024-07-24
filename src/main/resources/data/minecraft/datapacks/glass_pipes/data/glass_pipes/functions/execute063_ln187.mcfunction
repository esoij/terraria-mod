function glass_pipes:is_pipe
scoreboard players set Global mai_scratch3 1
execute unless score Global ReturnValue matches 1.. run function glass_pipes:execute062_ln188
execute if score Global mai_scratch3 matches 1.. run scoreboard players set @s exit_junction 0