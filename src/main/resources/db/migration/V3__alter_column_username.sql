DO $$
DECLARE
    nome_da_tabela text := 'users';
    nome_da_coluna text := 'username';
    nome_da_restrição_unique text;
BEGIN
    SELECT constraint_name
    INTO nome_da_restrição_unique
    FROM information_schema.constraint_column_usage
    WHERE table_name = nome_da_tabela AND column_name = nome_da_coluna;

    IF nome_da_restrição_unique IS NOT NULL THEN
        EXECUTE 'ALTER TABLE ' || nome_da_tabela || ' DROP CONSTRAINT ' || nome_da_restrição_unique;
    ELSE
        RAISE NOTICE 'A coluna não tem uma restrição UNIQUE.';
    END IF;
END $$;