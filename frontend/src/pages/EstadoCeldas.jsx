import React, { useEffect, useState } from 'react';
import axios from 'axios';

const EstadoCeldas = () => {
  const [celdas, setCeldas] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/celdas/all')
      .then(res => setCeldas(res.data))
      .catch(err => console.error('Error al obtener celdas:', err));
  }, []);

  return (
    <div>
      <h2>Estado de las Celdas</h2>
      <table border="1">
        <thead>
          <tr>
            <th>Número</th>
            <th>Disponibilidad</th>
          </tr>
        </thead>
        <tbody>
          {celdas.map(celda => (
            <tr key={celda.id}>
              <td>{celda.numero}</td>
              <td style={{ color: celda.disponibilidad === 'OCUPADA' ? 'red' : 'green' }}>
                {celda.disponibilidad}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default EstadoCeldas;
