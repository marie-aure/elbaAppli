insert into liaisoncofa (commentaire,progression, valeur, valide, condition_id, famille_id)
select '', '', 0, false, c.id as cond, f.id as fam from conditions c
cross join familles f
order by f.id asc, c.id asc;


