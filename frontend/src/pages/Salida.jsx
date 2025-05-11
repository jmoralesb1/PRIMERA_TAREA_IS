import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Salida = () => {
  const [registros, setRegistros] = useState([]);
  const [idRegistro, setIdRegistro] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8080/api/registro/activos')
      .then(res => setRegistros(res.data))
      .catch(err => console.error('Error obteniendo registros activos:', err));
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post(`http://localhost:8080/api/registro/salida/${idRegistro}`);
      alert('Salida registrada correctamente');
      setIdRegistro('');
      // recargar lista de registros activos
      const res = await axios.get('http://localhost:8080/api/registro/activos');
      setRegistros(res.data);
    } catch (err) {
      console.error('Error al registrar salida:', err);
      alert('Error al registrar salida del vehículo.');
    }
  };

  return (
    <div>
      <h2>Registrar Salida</h2>
      <form onSubmit={handleSubmit}>
        <select value={idRegistro} onChange={(e) => setIdRegistro(e.target.value)} required>
          <option value="">Seleccione un vehículo</option>
          {registros.map((reg) => (
            <option key={reg.idR} value={reg.idR}>
              {reg.vehiculo.placa} - Entrada: {new Date(reg.fechaEntrada).toLocaleString()}
            </option>
          ))}
        </select>
        <button type="submit">Registrar Salida</button>
      </form>
    </div>
  );
};

export default Salida;
