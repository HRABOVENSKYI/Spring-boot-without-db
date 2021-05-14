package ua.lviv.iot.loomshop.services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.loomshop.models.loom.Loom;
import ua.lviv.iot.loomshop.services.LoomService;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoomServiceImpl implements LoomService {

    private Long id = 0L;
    private Map<Long, Loom> looms = new HashMap<>();

    @Override
    public Loom createLoom(Loom loom) {
        looms.put(++id, loom);
        return loom;
    }

    @Override
    public Map<Long, Loom> getAllLooms() {
        return looms;
    }

    @Override
    public Loom getLoom(Long id) {
        return looms.get(id);
    }

    /**
     * Returns 200 status code and previous loom object if loom with this id exists
     * Returns 404 status code if loom with this id is missing
     */
    @Override
    public ResponseEntity<Loom> updateLoomById(Long id, Loom newLoom) {

        Loom oldLoom = getLoom(id);
        return looms.replace(id, newLoom) != null ? new ResponseEntity<>(oldLoom, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public void deleteAllLooms() {
        looms = new HashMap<>();
    }

    @Override
    public void deleteLoomById(Long id) {
        looms.remove(id);
    }
}
