tail -f $(find . -type f -name \*-mtc.log) | sed 's#fail#\x1b[31m&\x1b[37m#;
s#pass#\x1b[32m&\x1b[37m#; s#none#\x1b[33m&\x1b[37m#; s#error#\x1b[35m&\x1b[37m#; s#inconclusive#\x1b[96m&\x1b[37m#;'
